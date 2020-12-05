import { Moment } from 'moment';

export interface IVisit {
  id?: number;
  startTime?: Moment;
  durationMin?: number;
  completed?: boolean;
  description?: string;
  comments?: string;
  cost?: number;
  personId?: number;
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
    public personId?: number
  ) {
    this.completed = this.completed || false;
  }
}
