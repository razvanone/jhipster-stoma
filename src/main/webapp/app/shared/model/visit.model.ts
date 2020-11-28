import { Moment } from 'moment';

export interface IVisit {
  id?: number;
  createdDate?: Moment;
  updatedDate?: Moment;
  targetDate?: Moment;
  durationMin?: number;
  patientId?: number;
  doctorId?: number;
  title?: string;
  description?: string;
  cost?: number;
  patientIdId?: number;
  doctorIdId?: number;
}

export class Visit implements IVisit {
  constructor(
    public id?: number,
    public createdDate?: Moment,
    public updatedDate?: Moment,
    public targetDate?: Moment,
    public durationMin?: number,
    public patientId?: number,
    public doctorId?: number,
    public title?: string,
    public description?: string,
    public cost?: number,
    public patientIdId?: number,
    public doctorIdId?: number
  ) {}
}
