import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {FacilityListComponent} from './facility-list/facility-list.component';
import {FacilityCreateComponent} from './facility-create/facility-create.component';
import {FacilityDetailComponent} from './facility-detail/facility-detail.component';
import {FacilityEditComponent} from './facility-edit/facility-edit.component';


const routes: Routes = [
  {
    path: '', component: FacilityListComponent
  },
  {
    path: 'create/:type', component: FacilityCreateComponent
  },
  {
    path: 'detail/:type/:id', component: FacilityDetailComponent
  },
  {
    path: 'edit/:type/:id', component: FacilityEditComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FacilityRoutingModule { }
