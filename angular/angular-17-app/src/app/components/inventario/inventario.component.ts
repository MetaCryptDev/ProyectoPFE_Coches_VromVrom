import { Component } from '@angular/core';
import { FooterComponent } from '../footer/footer.component';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { InventarioService } from '../../servicios/inventario-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { Inventario } from '../../dto/inventario';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-inventario',
  standalone: true,
  imports: [FooterComponent,FormsModule,HttpClientModule,RouterModule, CommonModule],
  templateUrl: './inventario.component.html',
  styleUrls:  ['../../../assets/css/custom.css','../../../assets/css/templatemo.css','../../../assets/css/fontawesome.css','../../../assets/css/fontawesome.min.css']
})
export class InventarioComponent {
  title : string = 'Nuevo producto';

  inventario : Inventario = new Inventario();

  listaInventario: Inventario[]= [];

  constructor(private inventarioService : InventarioService,
              private router : Router,
              private activatedRouter : ActivatedRoute) {}

              ngOnInit(){
                this.buscarProductos()
              }
            
  crearProducto() : void {
    this.inventarioService.saveProducto(this.inventario).subscribe(
      response => {
        this.router.navigate(['/inventario']); 
          
      }
    );
  }

  actualizarProducto(pieza: Inventario) : void {
    if (pieza.cantidad<=0 || pieza.cantidad==null){
      pieza.cantidad = 0
    }
    alert(JSON.stringify(pieza));
    this.inventarioService.updateProducto(pieza).subscribe(
      response => {
        this.router.navigate(['/inventario'])
       
      }
    );
  }

  eliminarProducto() : void {
    this.inventarioService.removeInventario(this.inventario.idPieza).subscribe(
      response => {
        this.router.navigate(['/inventario'])
       
      }
    );
  }

  buscarUnProducto() : void {
    this.inventarioService.findById(this.inventario.idPieza).subscribe(
      response => {
        this.router.navigate(['/inventario'])
       
      }
    );
  }  

  buscarProductos(): void {
    this.inventarioService.findAll().subscribe(
      (response: Inventario[]) => {
        this.listaInventario = response;
      }
    );
  }

  buscarPorDescripcion(): void {
    this.listaInventario = [];
    this.inventarioService.findPorDescripcion(this.inventario).subscribe(
      (response: Inventario[]) => {
        this.listaInventario = response;
      }
      
    );
  }

}
