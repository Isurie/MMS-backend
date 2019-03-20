import { Component, OnInit, ViewChild, Input } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog, MAT_DIALOG_DATA } from '@angular/material';
import { ReportrequestService } from '../reportrequest.service';
import {Subject} from 'rxjs';
import { Inject } from '@angular/core';
import {enableProdMode} from '@angular/core';
import { Reportrequest } from '../reportrequest';
import { GenerateReportComponent } from '../generate-report/generate-report.component';

@Component({
  selector: 'app-member-reports',
  templateUrl: './member-reports.component.html',
  styleUrls: ['./member-reports.component.css']
})
export class MemberReportsComponent implements OnInit {
  // dataSource: any;
memberid: number;
reportrequest: Reportrequest[];

displayedColumns = ['memberid']
dataSource = new MatTableDataSource();

@ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  constructor(private reportrequestservice:ReportrequestService,public dialog:MatDialog) { }

  ngOnInit() {
    return this.reportrequestservice.getReportrequest().subscribe(rest=>this.dataSource.data=rest);
  }

  openDialog(member) {
    const dialogRef = this.dialog.open(GenerateReportComponent, {
      height:'600px',
      width: '800px',
      data: event
    });
    dialogRef.afterClosed().subscribe(result => {
      this.ngOnInit();
    });

  }

}
