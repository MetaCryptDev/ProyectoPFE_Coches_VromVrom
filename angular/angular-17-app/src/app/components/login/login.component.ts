import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FooterComponent],
  templateUrl: './login.component.html',
  styleUrls: ['../../../assets/css/custom.css','../../../assets/css/templatemo.css','../../../assets/css/fontawesome.css','../../../assets/css/fontawesome.min.css',"../../../assets/css/login.css"]
})
export class LoginComponent {

}
