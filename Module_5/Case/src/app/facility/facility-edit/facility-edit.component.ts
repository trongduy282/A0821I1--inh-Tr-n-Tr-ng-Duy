import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormArray, FormControl, FormGroup} from '@angular/forms';
import {RentType} from '../../model/rent-type';
import {AttachService} from '../../model/attach-service';
import {FacilityService} from '../../servicenew/facility.service';


@Component({
  selector: 'app-facility-edit',
  templateUrl: './facility-edit.component.html',
  styleUrls: ['./facility-edit.component.css']
})
export class FacilityEditComponent implements OnInit {
  type: string;
  rent_types: RentType[];
  free_services: AttachService[];
  chooses: Boolean[];
  form: FormGroup;
  constructor(private activatedRoute: ActivatedRoute, private facilityService: FacilityService, private router: Router) { }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((p: ParamMap) => {
      this.type = p.get('type').toLowerCase();
      const id: number = Number(p.get('id'));
      this.form = new FormGroup({
        id: new FormControl(),
        name: new FormControl(),
        area: new FormControl(),
        cost: new FormControl(),
        max_people: new FormControl(),
        rent_type: new FormControl(),
      });

      if (this.type === 'room') {
        this.form.addControl('free_services', new FormArray([]));
        this.facilityService.getRoom(id).subscribe(t => {
          this.form.patchValue(t);
          console.log(this.form.value);
          console.log(t);
        });
        this.facilityService.getFreeService().subscribe(t => {
          this.free_services = t;
          this.chooses = new Array(t.length).fill(false);
        });
      } else if (this.type === 'house' || this.type === 'villa') {
        this.form.addControl('standard', new FormControl());
        this.form.addControl('description', new FormControl());
        this.form.addControl('number_floor', new FormControl());
        if (this.type === 'house') {
          this.facilityService.getHouse(id).subscribe(t => this.form.patchValue(t));
        } else if (this.type === 'villa') {
          this.form.addControl('area_pool', new FormControl());
          this.facilityService.getVilla(id).subscribe(t => this.form.patchValue(t));
        }
      }

      this.facilityService.getRentTypes().subscribe(rts => this.rent_types = rts);
    });
  }

  get freeServicesFormArray() {
    return this.form.controls.free_services as FormArray;
  }

  getForm() {
    console.log(this.form.value);
  }
}
