import { Component, OnInit } from '@angular/core';
import {Contract} from '../contract';

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contracts: Contract[] = [
    {contractNumber: '1', startDate: '2020/02/28', endDate: '2020/03/03', deposit: '2000000', total: '10000000'},
    {contractNumber: '2', startDate: '2020/03/06', endDate: '2020/03/12', deposit: '3000000', total: '7000000'},
    {contractNumber: '3', startDate: '2020/04/28', endDate: '2020/05/03', deposit: '1000000', total: '9000000'}
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
