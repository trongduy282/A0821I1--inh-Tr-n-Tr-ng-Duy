import {RentType} from './rent-type';

export abstract class Facility {
  id: number;
  name: string;
  area: number;
  cost: number;
  max_people: number;
  rent_type: RentType;
}
