export interface IAddress {
  id?: number;
  streetAddress?: string;
  postalCode?: string;
  city?: string;
  stateProvince?: string;
  personId?: number;
  doctorId?: number;
}

export class Address implements IAddress {
  constructor(
    public id?: number,
    public streetAddress?: string,
    public postalCode?: string,
    public city?: string,
    public stateProvince?: string,
    public personId?: number,
    public doctorId?: number
  ) {}
}
