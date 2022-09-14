import {Component, OnInit} from '@angular/core';
import {ActivatedRoute, ParamMap, Router} from '@angular/router';
import {FormArray, FormControl, FormGroup} from '@angular/forms';
import {RentType} from '../../model/rent-type';
import {AttachService} from '../../model/attach-service';
import {FacilityService} from '../../servicenew/facility.service';
// import {RentType} from '../../../models/rent-type';
// import {AttachService} from '../../../models/attach-service';
// import {FacilityService} from '../../../services/facility.service';

@Component({
  selector: 'app-facility-create',
  templateUrl: './facility-create.component.html',
  styleUrls: ['./facility-create.component.css']
})
export class FacilityCreateComponent implements OnInit {
  type_facility: string;
  rent_types: RentType[];
  free_services: AttachService[];
  chooses: Boolean[];
  form: FormGroup;

  constructor(private activatedRoute: ActivatedRoute, private facilityService: FacilityService, private router: Router) {
  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((p: ParamMap) => {
      this.type_facility = p.get('type').toLowerCase();
      this.form = new FormGroup({
        id: new FormControl(),
        name: new FormControl(),
        area: new FormControl(),
        cost: new FormControl(),
        max_people: new FormControl(),
        rent_type: new FormControl(null),
      });

      if (this.type_facility === 'room') {
        this.form.addControl('free_services', new FormArray([]));
      } else if (this.type_facility === 'house') {
        this.form.addControl('standard', new FormControl());
        this.form.addControl('description', new FormControl());
        this.form.addControl('number_floor', new FormControl());
      } else if (this.type_facility === 'villa') {
        this.form.addControl('standard', new FormControl());
        this.form.addControl('description', new FormControl());
        this.form.addControl('number_floor', new FormControl());
        this.form.addControl('area_pool', new FormControl());
      }
      this.facilityService.getRentTypes().subscribe(rts => this.rent_types = rts);

      if (this.type_facility === 'room') {
        this.facilityService.getFreeService().subscribe(t => {
          this.free_services = t;
          this.chooses = new Array(t.length).fill(false);
        });
      }
    });
  }

  get freeServicesFormArray() {
    return this.form.controls.free_services as FormArray;
  }

  save() {
    if (this.type_facility === 'room') {
      this.chooses.forEach((value, index) => {
        value ? this.freeServicesFormArray.push(new FormControl(this.free_services[index])) : false;
      });
    }
    this.facilityService.create(this.form.value, this.type_facility).subscribe(
      next => alert('success'),
      error => alert(error.error.message)
    );
    // this.router.navigateByUrl('/facilities');
    window.location.href = '/facilities';
  }

  changeSelectedFreeServices(index: number) {
    this.chooses[index] = !this.chooses[index];
  }
}
