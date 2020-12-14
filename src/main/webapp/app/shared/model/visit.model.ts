import { Moment } from 'moment';
import { IMaterial } from 'app/shared/model/material.model';

export interface IVisit {
  id?: number;
  startTime?: Moment;
  durationMin?: number;
  completed?: boolean;
  description?: string;
  comments?: string;
  cost?: number;
  patientLastName?: string;
  patientId?: number;
  userLogin?: string;
  userId?: number;
  materials?: IMaterial[];
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
    public patientLastName?: string,
    public patientId?: number,
    public userLogin?: string,
    public userId?: number,
    public materials?: IMaterial[]
  ) {
    this.completed = this.completed || false;
  }
}
