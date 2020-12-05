import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    RouterModule.forChild([
      {
        path: 'region',
        loadChildren: () => import('./region/region.module').then(m => m.StomaRegionModule),
      },
      {
        path: 'country',
        loadChildren: () => import('./country/country.module').then(m => m.StomaCountryModule),
      },
      {
        path: 'address',
        loadChildren: () => import('./address/address.module').then(m => m.StomaAddressModule),
      },
      {
        path: 'patient',
        loadChildren: () => import('./patient/patient.module').then(m => m.StomaPatientModule),
      },
      {
        path: 'visit',
        loadChildren: () => import('./visit/visit.module').then(m => m.StomaVisitModule),
      },
      {
        path: 'material',
        loadChildren: () => import('./material/material.module').then(m => m.StomaMaterialModule),
      },
      {
        path: 'location',
        loadChildren: () => import('./location/location.module').then(m => m.StomaLocationModule),
      },
      {
        path: 'department',
        loadChildren: () => import('./department/department.module').then(m => m.StomaDepartmentModule),
      },
      {
        path: 'task',
        loadChildren: () => import('./task/task.module').then(m => m.StomaTaskModule),
      },
      {
        path: 'employee',
        loadChildren: () => import('./employee/employee.module').then(m => m.StomaEmployeeModule),
      },
      {
        path: 'job',
        loadChildren: () => import('./job/job.module').then(m => m.StomaJobModule),
      },
      {
        path: 'job-history',
        loadChildren: () => import('./job-history/job-history.module').then(m => m.StomaJobHistoryModule),
      },
      /* jhipster-needle-add-entity-route - JHipster will add entity modules routes here */
    ]),
  ],
})
export class StomaEntityModule {}
