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
import { IPerson } from 'app/shared/model/person.model';
import { PersonService } from 'app/entities/person/person.service';

@Component({
  selector: 'jhi-visit-update',
  templateUrl: './visit-update.component.html',
})
export class VisitUpdateComponent implements OnInit {
  isSaving = false;
  people: IPerson[] = [];

  editForm = this.fb.group({
    id: [],
    createdDate: [],
    updatedDate: [],
    targetDate: [],
    durationMin: [],
    patientId: [],
    doctorId: [],
    title: [],
    description: [],
    cost: [],
    patientIdId: [],
    doctorIdId: [],
  });

  constructor(
    protected visitService: VisitService,
    protected personService: PersonService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit(): void {
    this.activatedRoute.data.subscribe(({ visit }) => {
      if (!visit.id) {
        const today = moment().startOf('day');
        visit.createdDate = today;
        visit.updatedDate = today;
        visit.targetDate = today;
      }

      this.updateForm(visit);

      this.personService.query().subscribe((res: HttpResponse<IPerson[]>) => (this.people = res.body || []));
    });
  }

  updateForm(visit: IVisit): void {
    this.editForm.patchValue({
      id: visit.id,
      createdDate: visit.createdDate ? visit.createdDate.format(DATE_TIME_FORMAT) : null,
      updatedDate: visit.updatedDate ? visit.updatedDate.format(DATE_TIME_FORMAT) : null,
      targetDate: visit.targetDate ? visit.targetDate.format(DATE_TIME_FORMAT) : null,
      durationMin: visit.durationMin,
      patientId: visit.patientId,
      doctorId: visit.doctorId,
      title: visit.title,
      description: visit.description,
      cost: visit.cost,
      patientIdId: visit.patientIdId,
      doctorIdId: visit.doctorIdId,
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
      createdDate: this.editForm.get(['createdDate'])!.value
        ? moment(this.editForm.get(['createdDate'])!.value, DATE_TIME_FORMAT)
        : undefined,
      updatedDate: this.editForm.get(['updatedDate'])!.value
        ? moment(this.editForm.get(['updatedDate'])!.value, DATE_TIME_FORMAT)
        : undefined,
      targetDate: this.editForm.get(['targetDate'])!.value ? moment(this.editForm.get(['targetDate'])!.value, DATE_TIME_FORMAT) : undefined,
      durationMin: this.editForm.get(['durationMin'])!.value,
      patientId: this.editForm.get(['patientId'])!.value,
      doctorId: this.editForm.get(['doctorId'])!.value,
      title: this.editForm.get(['title'])!.value,
      description: this.editForm.get(['description'])!.value,
      cost: this.editForm.get(['cost'])!.value,
      patientIdId: this.editForm.get(['patientIdId'])!.value,
      doctorIdId: this.editForm.get(['doctorIdId'])!.value,
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

  trackById(index: number, item: IPerson): any {
    return item.id;
  }
}
