import { Component, OnInit } from '@angular/core';
import { Condominio } from '../Interface/CondominioInterface';
import { CondominioService } from '../service/condominio.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-condominios',
  templateUrl: './listar-condominios.component.html',
  styleUrls: ['./listar-condominios.component.css'],
})
export class ListarCondominiosComponent implements OnInit {
  listaCondominio: Condominio[] = [];

  constructor(private service: CondominioService, private router: Router) {}

  ngOnInit(): void {
    this.service.listar().subscribe((page) => {
      this.listaCondominio = page.content;
    });
  }

  listarApartamentos(condominioId: number): void {
    this.router.navigate([`/apartamentos/${condominioId}`]);
    //alert("ma oe")
  }
}