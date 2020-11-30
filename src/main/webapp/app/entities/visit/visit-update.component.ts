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
import { IDoctor } from 'app/shared/model/doctor.model';
import { DoctorService } from 'app/entities/doctor/doctor.service';

type SelectableEntity = IPerson | IDoctor;

@Component({
  selector: 'jhi-visit-update',
  templateUrl: './visit-update.component.html',
})
export class VisitUpdateComponent implements OnInit {
  isSaving = false;
  people: IPerson[] = [];
  doctors: IDoctor[] = [];

  editForm = this.fb.group({
    id: [],
    startTime: [],
    durationMin: [],
    completed: [],
    description: [],
    comments: [],
    cost: [],
    person: [],
    doctor: [],
  });

  constructor(
    protected visitService: VisitService,
    protected personService: PersonService,
    protected doctorService: DoctorService,
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

      this.personService.query().subscribe((res: HttpResponse<IPerson[]>) => (this.people = res.body || []));

      this.doctorService.query().subscribe((res: HttpResponse<IDoctor[]>) => (this.doctors = res.body || []));
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
      person: visit.person,
      doctor: visit.doctor,
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
      person: this.editForm.get(['person'])!.value,
      doctor: this.editForm.get(['doctor'])!.value,
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
}
