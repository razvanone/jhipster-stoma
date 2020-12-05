import { IVisit } from 'app/shared/model/visit.model';

export interface IPerson {
  id?: number;
  firstName?: string;
  lastName?: string;
  phoneNumber?: string;
  email?: string;
  visits?: IVisit[];
  addressId?: number;
}

export class Person implements IPerson {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public phoneNumber?: string,
    public email?: string,
    public visits?: IVisit[],
    public addressId?: number
  ) {}
}
