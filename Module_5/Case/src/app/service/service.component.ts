import { Component, OnInit } from '@angular/core';
import {Facility} from "../facility";

@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {

  facilities: Facility[] = [
    {serviceName: 'OceanSuite',area: '85m2',rentCost: '10000000',maxPerson:'3',rentType:'ngày',roomStandard:'5 sao'},
    {serviceName: 'Lagoon Superior',area: '75m2',rentCost: '7000000',maxPerson:'2',rentType:'tháng',roomStandard:'4 sao'},
    {serviceName: 'Garden Superior',area: '65m2',rentCost: '6000000',maxPerson:'2',rentType:'năm',roomStandard:'3 sao'}
  ]
  constructor() { }

  ngOnInit(): void {
  }

}
