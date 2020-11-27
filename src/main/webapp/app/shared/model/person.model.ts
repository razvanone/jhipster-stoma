export interface IPerson {
  id?: number;
  firstName?: string;
  lastName?: string;
  email?: string;
  phoneNumber?: string;
  addressId?: number;
  addressIdId?: number;
}

export class Person implements IPerson {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public email?: string,
    public phoneNumber?: string,
    public addressId?: number,
    public addressIdId?: number
  ) {}
}
