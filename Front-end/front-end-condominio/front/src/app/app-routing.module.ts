import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarCondominiosComponent } from './listar-condominios/listar-condominios.component';
import { ListarApartamentoComponent } from './listar-apartamento/listar-apartamento.component';
import { CriarApartamentoComponent } from './criar-apartamento/criar-apartamento.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'listarCondominio',
    pathMatch: 'full'
  },
  {
    path:'listarCondominio',
    component: ListarCondominiosComponent
  },
  {
    path: 'apartamentos/:id',
    component: ListarApartamentoComponent
  },
  {
    path:'criarApartamento/:id',
    component: CriarApartamentoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }