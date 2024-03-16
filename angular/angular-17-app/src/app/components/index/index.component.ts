import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { HttpClientModule } from '@angular/common/http';
@Component({
  selector: 'app-index',
  standalone: true,
  imports: [FooterComponent,HttpClientModule],
  templateUrl: './index.component.html',
  styleUrls: ['../../../assets/css/custom.css','../../../assets/css/templatemo.css','../../../assets/css/fontawesome.css','../../../assets/css/fontawesome.min.css']
})
export class IndexComponent {

}
