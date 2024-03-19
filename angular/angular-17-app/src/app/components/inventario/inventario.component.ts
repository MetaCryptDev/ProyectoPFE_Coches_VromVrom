import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { InventarioService } from '../../servicios/inventario-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Inventario } from '../../dto/inventario';

@Component({
  selector: 'app-inventario',
  standalone: true,
  imports: [FooterComponent,FormsModule,HttpClientModule,RouterModule],
  templateUrl: './inventario.component.html',
  styleUrls:  ['../../../assets/css/custom.css','../../../assets/css/templatemo.css','../../../assets/css/fontawesome.css','../../../assets/css/fontawesome.min.css']
})
export class InventarioComponent {
  title : string = 'Nuevo producto';

   inventario : Inventario = new Inventario();

  constructor(private inventarioService : InventarioService,
              private router : Router,
              private activatedRouter : ActivatedRoute) {}

            
  crearProducto() : void {
    this.inventarioService.saveProducto(this.inventario).subscribe(
      response => {
        this.router.navigate(['/listadoProductos']); 
          
      }
    );
  }

  actualizarProducto() : void {
    this.inventarioService.updateProducto(this.inventario).subscribe(
      response => {
        this.router.navigate(['/listadoProductos'])
       
      }
    );
  }

  eliminarProducto() : void {
    this.inventarioService.removeInventario(this.inventario.idPieza).subscribe(
      response => {
        this.router.navigate(['/listadoProductos'])
       
      }
    );
  }

  buscarUnProducto() : void {
    this.inventarioService.findById(this.inventario.idPieza).subscribe(
      response => {
        this.router.navigate(['/listadoProductos'])
       
      }
    );
  }  

  buscarProductos() : void {
    this.inventarioService.findAll().subscribe(
      response => {
        this.router.navigate(['/listadoProductos'])
       
      }
    );
  }

}
