import { Component, OnInit, Inject } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource, MatDialog, MatDialogRef, MAT_DIALOG_DATA } from '@angular/material';
import { ReportrequestService } from '../reportrequest.service';


@Component({
  selector: 'app-generate-report',
  templateUrl: './generate-report.component.html',
  styleUrls: ['./generate-report.component.css']
})
export class GenerateReportComponent implements OnInit {

  constructor(private dialogRef:MatDialogRef<GenerateReportComponent>,@Inject(MAT_DIALOG_DATA) data) { }

  ngOnInit() {
  }

}
