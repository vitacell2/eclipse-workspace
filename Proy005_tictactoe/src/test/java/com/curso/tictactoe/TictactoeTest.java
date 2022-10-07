package com.curso.tictactoe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TictactoeTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void sumarDosMasDosDara4() {
		//datos entra
		Tictactoe juego = new Tictactoe();
		int n = 2;
		int n2 = 2;
		
		//resultado esperado
		int espero=4;
		
		//resultado real
		int r = juego.suma(n,n2);
		
		//si no coinciden fallo
		if(espero != r) fail("No sumado 2+2=4 sino que el r " +r);
		
		//fail("Not yet implemented");
	}
	
	@Test(expected = RuntimeException.class)
	public void PonerFichaEnCoordenadaXMalLanzaUnaExcepcion()
	{
		Tictactoe juego = new Tictactoe();
		
		// 3 filas y 3 columnas (0 a 2)
		juego.jugar(4,2); //falla si no lanza un RunTimeException
	}
	
	public void PonerFichaEnCoordenadaYMalLanzaUnaExcepcion()
	{
		Tictactoe juego = new Tictactoe();
		
		// 3 filas y 3 columnas (0 a 2)
		juego.jugar(2,4); //falla si no lanza un RunTimeException
	}
	
	public void PonerFichasEnPosicionQueYaHayOtraLanzaUnaExcepcion()
	{
		//preparar escenario
		Tictactoe juego = new Tictactoe(); //debe lanzar una excepcion
		juego.jugar(0, 0);
		juego.jugar(0, 0); //debe lanzar una Excepcion
	}
	
	@Test
	public void PonerFichaXeYBienEsperaQueEnEstaPosicionYaNoSeaNull()
	{
		Tictactoe juego = new Tictactoe();
		juego.jugar(0, 0);
		
		if(juego.verFicha(0,0) == null)
		{
			fail("La ficha debe estar en esta posicion y no hay ficha");
		}
	}
	
	@Test
	public void primerJugadorEsX()
	{
		Tictactoe juego = new Tictactoe();
		juego.jugar(0, 0);
		
		if(juego.getJugadorActual() != 'X')
		{
			fail("El primer jugador debe ser X ");
		}
	}
	
    @Test
    public void siAnterioJugadorEsXAhoraEsO() {
    	Tictactoe juego = new Tictactoe();
    	juego.jugar(0, 0);
    	if (juego.getJugadorActual() != 'O') {
    		fail("El primer judagor debe ser O ");
    	}
    }
    
    @Test
    public void siAnterioJugadorEsOAhoraEsX() {
    	Tictactoe juego = new Tictactoe();
    	juego.jugar(0, 0);
    	juego.jugar(0, 2);
    	if (juego.getJugadorActual() != 'X') {
    		fail("El primer judagor debe ser X ");
    	}
    }
	
}
