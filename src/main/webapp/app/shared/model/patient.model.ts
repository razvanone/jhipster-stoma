import { Gender } from 'app/shared/model/enumerations/gender.model';

export interface IPatient {
  id?: number;
  firstName?: string;
  lastName?: string;
  phoneNumber?: string;
  email?: string;
  age?: number;
  gender?: Gender;
  addressStreetAddress?: string;
  addressId?: number;
}

export class Patient implements IPatient {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public phoneNumber?: string,
    public email?: string,
    public age?: number,
    public gender?: Gender,
    public addressStreetAddress?: string,
    public addressId?: number
  ) {}
}
