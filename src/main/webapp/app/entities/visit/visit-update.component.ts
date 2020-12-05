import { Component, OnInit } from '@angular/core';
import { HttpResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';

import { IVisit, Visit } from 'app/shared/model/visit.model';
import { VisitService } from './visit.service';
import { IPatient } from 'app/shared/model/patient.model';
import { PatientService } from 'app/entities/patient/patient.service';
import { IMaterial } from 'app/shared/model/material.model';
import { MaterialService } from 'app/entities/material/material.service';

type SelectableEntity = IPatient | IMaterial;

@Component({
  selector: 'jhi-visit-update',
  templateUrl: './visit-update.component.html',
})
export class VisitUpdateComponent implements OnInit {
  isSaving = false;
  patients: IPatient[] = [];
  materials: IMaterial[] = [];

  editForm = this.fb.group({
    id: [],
    startTime: [null, [Validators.required]],
    durationMin: [null, [Validators.required]],
    completed: [],
    description: [],
    comments: [],
    cost: [],
    patientId: [],
    materials: [],
  });

  constructor(
    protected visitService: VisitService,
    protected patientService: PatientService,
    protected materialService: MaterialService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ visit }) => {
      if (!visit.id) {
        const today = moment().startOf('day');
        visit.startTime = today;
      }

      this.updateForm(visit);

      this.patientService.query().subscribe((res: HttpResponse<IPatient[]>) => (this.patients = res.body || []));

      this.materialService.query().subscribe((res: HttpResponse<IMaterial[]>) => (this.materials = res.body || []));
    });
  }

  updateForm(visit: IVisit): void {
    this.editForm.patchValue({
      id: visit.id,
      startTime: visit.startTime ? visit.startTime.format(DATE_TIME_FORMAT) : null,
      durationMin: visit.durationMin,
      completed: visit.completed,
      description: visit.description,
      comments: visit.comments,
      cost: visit.cost,
      patientId: visit.patientId,
      materials: visit.materials,
    });
  }

  previousState(): void {
    window.history.back();
  }

  save(): void {
    this.isSaving = true;
    const visit = this.createFromForm();
    if (visit.id !== undefined) {
      this.subscribeToSaveResponse(this.visitService.update(visit));
    } else {
      this.subscribeToSaveResponse(this.visitService.create(visit));
    }
  }

  private createFromForm(): IVisit {
    return {
      ...new Visit(),
      id: this.editForm.get(['id'])!.value,
      startTime: this.editForm.get(['startTime'])!.value ? moment(this.editForm.get(['startTime'])!.value, DATE_TIME_FORMAT) : undefined,
      durationMin: this.editForm.get(['durationMin'])!.value,
      completed: this.editForm.get(['completed'])!.value,
      description: this.editForm.get(['description'])!.value,
      comments: this.editForm.get(['comments'])!.value,
      cost: this.editForm.get(['cost'])!.value,
      patientId: this.editForm.get(['patientId'])!.value,
      materials: this.editForm.get(['materials'])!.value,
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IVisit>>): void {
    result.subscribe(
      () => this.onSaveSuccess(),
      () => this.onSaveError()
    );
  }

  protected onSaveSuccess(): void {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError(): void {
    this.isSaving = false;
  }

  trackById(index: number, item: SelectableEntity): any {
    return item.id;
  }

  getSelected(selectedVals: IMaterial[], option: IMaterial): IMaterial {
    if (selectedVals) {
      for (let i = 0; i < selectedVals.length; i++) {
        if (option.id === selectedVals[i].id) {
          return selectedVals[i];
        }
      }
    }
    return option;
  }
}
