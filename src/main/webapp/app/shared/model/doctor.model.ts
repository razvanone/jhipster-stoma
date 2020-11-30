import { IAddress } from 'app/shared/model/address.model';
import { IVisit } from 'app/shared/model/visit.model';

export interface IDoctor {
  id?: number;
  firstName?: string;
  lastName?: string;
  phoneNumber?: string;
  email?: string;
  addresses?: IAddress[];
  visits?: IVisit[];
}

export class Doctor implements IDoctor {
  constructor(
    public id?: number,
    public firstName?: string,
    public lastName?: string,
    public phoneNumber?: string,
    public email?: string,
    public addresses?: IAddress[],
    public visits?: IVisit[]
  ) {}
}
