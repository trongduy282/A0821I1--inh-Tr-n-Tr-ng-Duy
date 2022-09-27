import {Group} from './group';
import {Teacher} from './teacher';

export interface Student {
  id: number;
  name: string;
  group: Group;
  projectName: string;
  teacher: Teacher;
  email: string;
  phone: string;
}
