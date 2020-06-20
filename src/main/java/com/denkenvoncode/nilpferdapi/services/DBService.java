package com.denkenvoncode.nilpferdapi.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.domain.Comanda;
import com.denkenvoncode.nilpferdapi.domain.ComandaIT;
import com.denkenvoncode.nilpferdapi.domain.ComandaPagto;
import com.denkenvoncode.nilpferdapi.domain.Endereco;
import com.denkenvoncode.nilpferdapi.domain.Fone;
import com.denkenvoncode.nilpferdapi.domain.Prod;
import com.denkenvoncode.nilpferdapi.domain.Unid;
import com.denkenvoncode.nilpferdapi.domain.Usuario;
import com.denkenvoncode.nilpferdapi.domain.enums.ClienteStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.ComandaITStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.ComandaPagtoTipoEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.ComandaStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.ComandoPagtoStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.EnderecoStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.FoneStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.ProdStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.UsuarioPerfilEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.UsuarioStatusEnum;
import com.denkenvoncode.nilpferdapi.repositories.ClienteRepository;
import com.denkenvoncode.nilpferdapi.repositories.ComandaITRepository;
import com.denkenvoncode.nilpferdapi.repositories.ComandaRepository;
import com.denkenvoncode.nilpferdapi.repositories.ProdRepository;
import com.denkenvoncode.nilpferdapi.repositories.UnidRepository;
import com.denkenvoncode.nilpferdapi.repositories.UsuarioRepository;

@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private UnidRepository unidRepository;
	
	@Autowired
	private ProdRepository prodRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ComandaRepository comandaRepository;
	
	@Autowired
	private ComandaITRepository comandaITRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;	
	
	public void StagingInitialize() {
		
		Usuario usuario1=new Usuario("Administrador", "Admin", "admin@nilpferd.com", UsuarioStatusEnum.Ativo);
		usuario1.setSenha(passwordEncoder.encode("123456"));
		usuario1.addPerfil(UsuarioPerfilEnum.Admin);
		Usuario usuario2=new Usuario("Gerente", "Gerente", "gerente@nilpferd.com",UsuarioStatusEnum.Ativo);
		usuario2.setSenha(passwordEncoder.encode("234567"));
		usuario1.addPerfil(UsuarioPerfilEnum.Gerente);
		Usuario usuario3=new Usuario("Fiscal", "Fiscal", "fiscal@nilpferd.com",UsuarioStatusEnum.Ativo);
		usuario3.setSenha(passwordEncoder.encode("345678"));
		usuario1.addPerfil(UsuarioPerfilEnum.Fiscal);
		Usuario usuario4=new Usuario("Operador", "Operador", "operador@nilpferd.com",UsuarioStatusEnum.Ativo);
		usuario4.setSenha(passwordEncoder.encode("456789"));
		Usuario usuario5=new Usuario("Cozinha", "Cozinha", "cozinha@nilpferd.com",UsuarioStatusEnum.Ativo);
		usuario5.setSenha(passwordEncoder.encode("567890"));
		Usuario usuario6=new Usuario("Entregador", "Entregador", "entregrador@nilpferd.com",UsuarioStatusEnum.Ativo);
		usuario6.setSenha(passwordEncoder.encode("678901"));
		usuarioRepository.saveAll(Arrays.asList(usuario1,usuario2,usuario3,usuario4,usuario5,usuario6));
		
		Unid unid1=new Unid("Unidade", "UN", 0);
		Unid unid2=new Unid("Kilo", "KG", 3);
		Unid unid3=new Unid("Unidade Balanca", "UB", 0);
		Unid unid4=new Unid("Fardo", "FD", 0);
		Unid unid5=new Unid("Caixa", "CX", 0);
		Unid unid6=new Unid("Caixa 6", "CX6", 0);
		Unid unid7=new Unid("Caixa 12", "CX12", 0);
		
		unidRepository.saveAll(Arrays.asList(unid1,unid2,unid3,unid4,unid5,unid6,unid7));
		
		
		Prod prod1=new Prod("Pao Frances",10.0,5.0,unid2,unid2,ProdStatusEnum.Ativo);
		Prod prod2=new Prod("Mortadela",20.0,10.0,unid2,unid2,ProdStatusEnum.Ativo);
		Prod prod3=new Prod("Coca Cola",6.0,3.0,unid1,unid1,ProdStatusEnum.Ativo);
		Prod prod4=new Prod("Tubaina",3.0,2.0,unid1,unid1,ProdStatusEnum.Ativo);
		Prod prod5=new Prod("Bolo Milho",15.0,12.0,unid3,unid3,ProdStatusEnum.Ativo);
		Prod prod6=new Prod("Leite Integral",25.0,15.0,unid7,unid7,ProdStatusEnum.Ativo);
		
		prodRepository.saveAll(Arrays.asList(prod1,prod2,prod3,prod4,prod5,prod6));
		
		Cliente cliente1=new Cliente("Lucas Luke","lucas@terra.com.br","123443",ClienteStatusEnum.Ativo);
		Endereco endereco1=new Endereco(cliente1,"Rua silveira","32","CJ 13","Tatuape","Sao Paulo","SP","023455",EnderecoStatusEnum.Ativo);
		Fone fone1=new Fone(cliente1, "23456745", FoneStatusEnum.Ativo);
		cliente1.getEnderecos().add(endereco1);
		cliente1.getFones().add(fone1);
		
		Cliente cliente2=new Cliente("Rafael Xitao","xitao@uol.com.br","123443",ClienteStatusEnum.Ativo);
		Endereco endereco2=new Endereco(cliente2,"Av Jose Luis","45","CJ 56","Santana","Sao Paulo","SP","023455",EnderecoStatusEnum.Ativo);
		Fone fone2=new Fone(cliente2, "45786565", FoneStatusEnum.Ativo);
		cliente2.getEnderecos().add(endereco2);
		cliente2.getFones().add(fone2);

		
		Cliente cliente3=new Cliente("Guilherme Trampo","guilherme@gmail.com","123443",ClienteStatusEnum.Ativo);
		Endereco endereco3=new Endereco(cliente3,"Largo da Batata","67","CJ 78","Pinheiros","Sao Paulo","SP","023455",EnderecoStatusEnum.Ativo);
		Fone fone3=new Fone(cliente3, "45786565", FoneStatusEnum.Ativo);
		cliente3.getEnderecos().add(endereco3);
		cliente3.getFones().add(fone3);

		Cliente cliente4=new Cliente("Amy","amy@hotmail.com","123443",ClienteStatusEnum.Ativo);
		Endereco endereco4=new Endereco(cliente4,"Av Paulista","456","CJ 76","Paulista","Sao Paulo","SP","023455",EnderecoStatusEnum.Ativo);
		Fone fone4=new Fone(cliente4, "45786565", FoneStatusEnum.Ativo);
		cliente4.getEnderecos().add(endereco4);
		cliente4.getFones().add(fone4);
		
		clienteRepository.saveAll(Arrays.asList(cliente1,cliente2,cliente3,cliente4));
		
		Comanda comanda1=new Comanda(new Date(),0.0,0.0,ComandaStatusEnum.Ativo,usuario1);
		ComandaIT item1=new ComandaIT(comanda1,1,prod1,2.0,0.0,ComandaITStatusEnum.Ativo);
		ComandaIT item2=new ComandaIT(comanda1,2,prod2,3.0,0.0,ComandaITStatusEnum.Ativo);
		ComandaIT item3=new ComandaIT(comanda1,3,prod3,1.0,0.0,ComandaITStatusEnum.Ativo);
		ComandaIT item4=new ComandaIT(comanda1,4,prod4,2.0,0.0,ComandaITStatusEnum.Ativo);
		comanda1.getItens().add(item1);
		comanda1.getItens().add(item2);
		comanda1.getItens().add(item3);
		comanda1.getItens().add(item4);
		comanda1.getDescontovl();
		comanda1.getTotalvl();
		
		ComandaPagto comandaPagto1=new ComandaPagto(comanda1,new Date(),40.0,40.0,1,ComandaPagtoTipoEnum.Debito,ComandoPagtoStatusEnum.Ativo);
		comanda1.getPagtos().add(comandaPagto1);
		
		comandaRepository.save(comanda1);
		
		//comandaITRepository.saveAll(comanda1.getItens());
		
	}
	
}
