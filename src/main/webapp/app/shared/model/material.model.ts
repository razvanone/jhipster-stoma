import { IVisit } from 'app/shared/model/visit.model';

export interface IMaterial {
  id?: number;
  name?: string;
  description?: string;
  unitCost?: number;
  quantity?: number;
  userLogin?: string;
  userId?: number;
  visits?: IVisit[];
}

export class Material implements IMaterial {
  constructor(
    public id?: number,
    public name?: string,
    public description?: string,
    public unitCost?: number,
    public quantity?: number,
    public userLogin?: string,
    public userId?: number,
    public visits?: IVisit[]
  ) {}
}
