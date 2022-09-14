import {CustomerType} from './customer-type';

export interface Customer {
  id: number;
  name: string;
  gender: boolean;
  identity: string;
  phone_number: string;
  email: string;
  address: string;
  customer_type: CustomerType;
}
