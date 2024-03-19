import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Inventario } from '../dto/inventario';

@Injectable({
  providedIn: 'root'
})
export class InventarioService {

  constructor(private http : HttpClient) { }

  private urlEndPoint : string = 'http://localhost:8080/cita/';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  findAll() : Observable<Inventario[]> {
    return this.http.get<Inventario[]>(this.urlEndPoint + 'verTodos');
  }

  saveProducto(inventario : Inventario) : Observable<Inventario> {
    return this.http.post<Inventario>(this.urlEndPoint + 'insertar', Inventario, {headers: this.httpHeaders});
  }

  removeInventario(idPieza: number) : Observable<Inventario> {
    return this.http.delete<Inventario>(this.urlEndPoint + 'eliminar/' + idPieza, {headers: this.httpHeaders});
  }

  findById(idPieza : number) : Observable<Inventario> {
    return this.http.get<Inventario>(this.urlEndPoint + 'recuperarUnaCita/' + idPieza);
  }

  updateProducto(inventario: Inventario) : Observable<Inventario> {
    return this.http.put<Inventario>(this.urlEndPoint + 'actualizar/' + inventario.idPieza, inventario, {headers: this.httpHeaders});
  }

}
