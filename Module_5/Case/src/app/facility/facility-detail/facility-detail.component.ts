import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {House} from '../../model/house';
import {Villa} from '../../model/villa';
import {Room} from '../../model/room';
import {FacilityService} from '../../servicenew/facility.service';

@Component({
  selector: 'app-facility-detail',
  templateUrl: './facility-detail.component.html',
  styleUrls: ['./facility-detail.component.css']
})
export class FacilityDetailComponent implements OnInit {
  facility: House | Villa | Room | any;
  type: string;
  id: number;
  constructor(private facilityService: FacilityService, private activatedRoute: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((p: ParamMap) => {
      this.type = p.get('type').toLowerCase();
      this.id = Number(p.get('id'));

      if (this.type === 'room') {
        this.facilityService.getRoom(this.id).subscribe(t => {
          this.facility = t;
        });
      } else if (this.type === 'house') {
        this.facilityService.getHouse(this.id).subscribe(t => this.facility = t);
      } else if (this.type === 'villa') {
        this.facilityService.getVilla(this.id).subscribe(t => this.facility = t);
      }
    });
  }

  navigateToEdit() {
    this.router.navigateByUrl('/facilities/edit/' + this.type + '/' + this.id);
  }

  delete() {
    this.facilityService.delete(this.facility.id, this.type).subscribe(
      next => {
        window.location.href = '/facilities';
      }
    );
  }
}
