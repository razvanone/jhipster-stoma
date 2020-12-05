export interface IMaterial {
  id?: number;
  name?: string;
  description?: string;
  unitCost?: number;
  quantity?: number;
}

export class Material implements IMaterial {
  constructor(public id?: number, public name?: string, public description?: string, public unitCost?: number, public quantity?: number) {}
}
