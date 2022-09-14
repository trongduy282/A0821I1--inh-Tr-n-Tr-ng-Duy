import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {FacilityRoutingModule} from './facility-routing.module';
import {HttpClientModule} from '@angular/common/http';
import {FacilityListComponent} from './facility-list/facility-list.component';
import {NgxPaginationModule} from 'ngx-pagination';
import {ReactiveFormsModule} from '@angular/forms';
import { FacilityCreateComponent } from './facility-create/facility-create.component';
import { FacilityDetailComponent } from './facility-detail/facility-detail.component';
import { FacilityEditComponent } from './facility-edit/facility-edit.component';

@NgModule({
  declarations: [FacilityListComponent, FacilityCreateComponent, FacilityDetailComponent, FacilityEditComponent],
  imports: [
    NgxPaginationModule,
    CommonModule,
    FacilityRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
  ]
})
export class FacilityModule {
}
