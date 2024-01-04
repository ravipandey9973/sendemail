import { Component, OnInit } from '@angular/core';
import { EmailService } from '../../service/email.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Observable} from 'rxjs';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrl: './email.component.css'
})
export class EmailComponent implements OnInit {
  data=
  {
    to:"",
    subject:"",
    message:""
  }
  flag:boolean=false;
  constructor(private email:EmailService,private snak:MatSnackBar) {}

  ngOnInit(): void {
    
  }

  doSubmitForm()
  {
    console.log("try to submit form");
    console.log("data",this.data);

    if(this.data.to=='' || this.data.subject=='' || this.data.message=='')
    {
       this.snak.open("fields can not be empty !!","OK");
       return;
    }
    this.flag=true;
    this.email.sendEmail(this.data).subscribe(
      (response:any)=>{
          console.log(response);
          this.flag=false;
          this.snak.open("send successfully","OK");
    },
    (error:any)=>{
         console.log(error);
         this.flag=false;
         this.snak.open("Error !!","OK");
     }
      
    
    );
  }
}
