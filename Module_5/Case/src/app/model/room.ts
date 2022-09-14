import {AttachService} from './attach-service';
import {Facility} from './facility';

export class Room extends Facility {
  free_services: AttachService[];
}
