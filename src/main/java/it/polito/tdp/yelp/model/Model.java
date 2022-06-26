package it.polito.tdp.yelp.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.yelp.db.YelpDao;

public class Model {
	
	YelpDao dao;
	Graph<Business, DefaultWeightedEdge> grafo;
	List<Business> vertici;
	Map<String, Business> idMapBusiness;
	
	public Model()
	
	{
		dao = new YelpDao();
		this.idMapBusiness = new HashMap<String, Business>();
	}
	
	public List<String> getCities()
	{
		return dao.getCities();
	}
	
	public String creaGrafo(String c)
	{
		grafo = new SimpleWeightedGraph<Business, DefaultWeightedEdge>(DefaultWeightedEdge.class);
		
		vertici = dao.getBusinessVERTICI(c);
		for(Business b: vertici)
		{
			this.idMapBusiness.put(b.getBusinessId(), b);
		}
		Graphs.addAllVertices(grafo, vertici);
		
		for(Adiacenza a:dao.getArchi(c))
		{
			Graphs.addEdgeWithVertices(grafo, idMapBusiness.get(a.getB1()),idMapBusiness.get(a.getB2()), a.getPeso());
		}
		
		return "Grafo creato con " + grafo.vertexSet().size() + " e " + grafo.edgeSet().size() + " archi";
	}

	public List<Business> getVertici() {
		return vertici;
	}

	public String getAdiacentePiuDistante(Business b)
	{
		List<Business> vicini = Graphs.neighborListOf(grafo, b);
		Business bok = null;
		double distanza = 0;
		
		for(Business b1:vicini)
		{
			if(grafo.getEdgeWeight(grafo.getEdge(b, b1))>distanza)
			{
				bok = b1;
				distanza = grafo.getEdgeWeight(grafo.getEdge(b, b1));
			}
		}
		
		return "LOCALE PIU' DISTANTE: \n" + bok + " = " + distanza;
	}
	
	
	
	
	
}
