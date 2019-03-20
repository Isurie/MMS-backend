import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator, MatSort, MatTableDataSource } from '@angular/material';
import { MemberService } from '../member.service';
import { TokenStorageService } from '../../auth/token-storage.service';
import { Member } from '../member';


@Component({
  selector: 'app-joinedevents-table',
  templateUrl: './joinedevents-table.component.html',
  styleUrls: ['./joinedevents-table.component.css'],
})
export class JoinedeventsTableComponent implements OnInit {
  info: any;
  username:string;
  member2 = new Member();
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  dataSource = new MatTableDataSource();
  members;

  constructor(private _memberService:MemberService,private token: TokenStorageService){}

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['eventid', 'eventname', 'venue', 'date','eventrating'];

  ngOnInit() {
    this.info = {
      token: this.token.getToken(),
      username: this.token.getUsername(),
      authorities: this.token.getAuthorities()
    };
    this.username=this.info.username;
    
    this._memberService.getidbyusername(this.username)
     .subscribe(data => this.member2=data);

    return this._memberService.getJoinedEvents(2).subscribe(rest=>this.dataSource.data=rest);
  }
  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  
}
