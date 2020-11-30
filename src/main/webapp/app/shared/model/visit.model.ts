import { Moment } from 'moment';
import { IPerson } from 'app/shared/model/person.model';
import { IDoctor } from 'app/shared/model/doctor.model';

export interface IVisit {
  id?: number;
  startTime?: Moment;
  durationMin?: number;
  completed?: boolean;
  description?: string;
  comments?: string;
  cost?: number;
  person?: IPerson;
  doctor?: IDoctor;
}

export class Visit implements IVisit {
  constructor(
    public id?: number,
    public startTime?: Moment,
    public durationMin?: number,
    public completed?: boolean,
    public description?: string,
    public comments?: string,
    public cost?: number,
    public person?: IPerson,
    public doctor?: IDoctor
  ) {
    this.completed = this.completed || false;
  }
}
