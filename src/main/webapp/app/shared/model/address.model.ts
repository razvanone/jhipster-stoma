import { IPatient } from 'app/shared/model/patient.model';

export interface IAddress {
  id?: number;
  streetAddress?: string;
  postalCode?: string;
  city?: string;
  county?: string;
  patients?: IPatient[];
}

export class Address implements IAddress {
  constructor(
    public id?: number,
    public streetAddress?: string,
    public postalCode?: string,
    public city?: string,
    public county?: string,
    public patients?: IPatient[]
  ) {}
}
