import { Gender } from 'app/shared/model/enumerations/gender.model';

export interface IPatient {
  id?: number;
  firstName?: string;
  lastName?: string;
  phoneNumber?: string;
  address?: string;
  email?: string;
  age?: number;
  gender?: Gender;
  userLogin?: string;
  userId?: number;
}

export class Patient implements IPatient {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public phoneNumber?: string,
    public address?: string,
    public email?: string,
    public age?: number,
    public gender?: Gender,
    public userLogin?: string,
    public userId?: number
  ) {}
}
