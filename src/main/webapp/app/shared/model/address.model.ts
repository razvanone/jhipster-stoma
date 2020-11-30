import { IPerson } from 'app/shared/model/person.model';
import { IDoctor } from 'app/shared/model/doctor.model';

export interface IAddress {
  id?: number;
  streetAddress?: string;
  postalCode?: string;
  city?: string;
  stateProvince?: string;
  person?: IPerson;
  doctor?: IDoctor;
}

export class Address implements IAddress {
  constructor(
    public id?: number,
    public streetAddress?: string,
    public postalCode?: string,
    public city?: string,
    public stateProvince?: string,
    public person?: IPerson,
    public doctor?: IDoctor
  ) {}
}
