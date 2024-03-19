import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { CitaService } from '../../servicios/cita-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Cita } from '../../dto/cita';

@Component({
  selector: 'app-cita',
  standalone: true,
  imports: [FooterComponent,FormsModule,HttpClientModule,RouterModule],
  templateUrl: './cita.component.html',
  styleUrls: ['../../../assets/css/custom.css','../../../assets/css/templatemo.css','../../../assets/css/fontawesome.css','../../../assets/css/fontawesome.min.css',"../../../assets/css/login.css"]
})
export class CitaComponent {

  title : string = 'Nuevo Cita';

    cita : Cita = new Cita();

    constructor(private citaService : CitaService,
                private router : Router,
                private activatedRouter : ActivatedRoute) {}

              
    crearCita() : void {
      this.citaService.saveCita(this.cita).subscribe(
        response => {
          this.router.navigate(['']); 
            
        }
      );
    }
}
