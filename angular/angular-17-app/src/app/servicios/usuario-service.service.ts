import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Usuario } from '../dto/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private http : HttpClient) { }

  private urlEndPoint : string = 'http://localhost:8080/usuarios/';
  private httpHeaders = new HttpHeaders({'Content-Type': 'application/json'});

  findAll() : Observable<Usuario[]> {
    return this.http.get<Usuario[]>(this.urlEndPoint + 'verTodos');
  }

  saveUsuario(usuario : Usuario) : Observable<Usuario> {
    return this.http.post<Usuario>(this.urlEndPoint + 'insertar', usuario, {headers: this.httpHeaders});
  }

  removeUsuario(idUsuario: number) : Observable<Usuario> {
    return this.http.delete<Usuario>(this.urlEndPoint + 'eliminar/' + idUsuario, {headers: this.httpHeaders});
  }

  findById(idUsuario : number) : Observable<Usuario> {
    return this.http.get<Usuario>(this.urlEndPoint + 'recuperarUnUsuario/' + idUsuario);
  }

  updateUsuario(usuario: Usuario) : Observable<Usuario> {
    return this.http.put<Usuario>(this.urlEndPoint + 'actualizar/' + usuario.idUsuario, usuario, {headers: this.httpHeaders});
  }

}
