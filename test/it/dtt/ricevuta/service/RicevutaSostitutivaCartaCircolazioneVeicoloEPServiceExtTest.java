package it.dtt.ricevuta.service;

import it.dtt.area.conducente.entity.RicevutaSostitutivaCartaCircolazioneVeicoloEP;
import it.dtt.ricevuta.entity.ext.RicevutaSostitutivaCartaCircolazioneVeicoloEPExt;
import it.dtt.ricevuta.factory.ext.RicevutaSostitutivaCartaCircolazioneVeicoloEPFactoryExt;
import it.dtt.ricevuta.service.ext.RicevutaSostitutivaCartaCircolazioneVeicoloEPServiceExt;

import java.sql.Timestamp;
import java.util.GregorianCalendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractTransactionalSpringContextTests;

public class RicevutaSostitutivaCartaCircolazioneVeicoloEPServiceExtTest extends
		AbstractTransactionalSpringContextTests {
	/**
	 * Default logger
	 */
	protected static Log logger = LogFactory
			.getLog(RicevutaSostitutivaCartaCircolazioneVeicoloEPServiceExtTest.class);

	private RicevutaSostitutivaCartaCircolazioneVeicoloEPServiceExt ricevutaSostitutivaCartaCircolazioneVeicoloEPService;

	protected String[] getConfigLocations() {
		return new String[] {
					"classpath*:it/dtt/ricevuta/propertyConfigurer.xml",
					"classpath*:it/dtt/area/common/applicationContext.xml",
					"classpath*:it/dtt/ricevuta/applicationContext.xml",
					"classpath*:it/dtt/sicurezza/applicationContext.xml",
					"classpath*:it/dtt/sicurezza/applicationContext-Model.xml",
					"classpath*:it/dtt/sicurezza/applicationContext-WS.xml",
//					"classpath*:it/dtt/ricevuta/applicationContext-Securing.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/trasportomerci/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/trasportomerci/applicationContext-Model.xml",		
					"classpath*:it/dtt/area/anagrafica/ricevuta/applicationContext-Model.xml",
					"classpath*:it/dtt/area/anagrafica/ricevuta/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/veicolo/ricevuta/applicationContext-Model.xml",
					"classpath*:it/dtt/area/veicolo/ricevuta/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/conducente/ricevuta/applicationContext-Model.xml",
					"classpath*:it/dtt/area/conducente/ricevuta/applicationContext-DAO.xml",
					"classpath*:it/dtt/area/conducente/ricevuta/applicationContext-ModelExt.xml",
					"classpath*:it/dtt/area/conducente/ricevuta/applicationContext-DAOExt.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-Model.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-ModelExt.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-DAOExt.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-POJO.xml",
					"classpath*:it/dtt/ricevuta/applicationContext-Action.xml"
				};
	}

	public RicevutaSostitutivaCartaCircolazioneVeicoloEPServiceExt getRicevutaSostitutivaCartaCircolazioneVeicoloEPService() {
		return ricevutaSostitutivaCartaCircolazioneVeicoloEPService;
	}

	public void setRicevutaSostitutivaCartaCircolazioneVeicoloEPService(
			RicevutaSostitutivaCartaCircolazioneVeicoloEPServiceExt ricevutaSostitutivaCartaCircolazioneVeicoloEPService) {
		this.ricevutaSostitutivaCartaCircolazioneVeicoloEPService = ricevutaSostitutivaCartaCircolazioneVeicoloEPService;
	}

	public void testDetail() {
		RicevutaSostitutivaCartaCircolazioneVeicoloEP ricevutaSostitutivaCartaCircolazioneVeicoloEP = ricevutaSostitutivaCartaCircolazioneVeicoloEPService
				.detail(getRicevutaSostitutivaCartaCircolazioneVeicoloEP());
		assertEquals("RM", ricevutaSostitutivaCartaCircolazioneVeicoloEP.getCodUffConcessionario());
		assertEquals("1002", ricevutaSostitutivaCartaCircolazioneVeicoloEP.getCodiceConcessionario());
		assertEquals("10", ricevutaSostitutivaCartaCircolazioneVeicoloEP.getProgressivoRilascioRicevutaSostitutiva());
	}

	public void testInsert() {
//		ricevutaSostitutivaCartaCircolazioneVeicoloEPService
//				.insert(getRicevutaSostitutivaCartaCircolazioneVeicoloEP());

		// spring test doesn't commit by default. 
		// using setComplete() all the changes made in this test case will be persisted
		//setComplete();

		// endTransaction() closes the db transaction.
		// useful for testing puroposes on beans values after the db connection closure
		//endTransaction();
	}

	public void testUpdate() {
		/**
		 *ricevutaSostitutivaCartaCircolazioneVeicoloEPService.update(getRicevutaSostitutivaCartaCircolazioneVeicoloEP());
		 **/

		// spring test doesn't commit by default. 
		// using setComplete() all the changes made in this test case will be persisted
		//setComplete();
		// endTransaction() closes the db transaction.
		// useful for testing puroposes on beans values after the db connection closure
		//endTransaction();
	}

	public void testDelete() {
		/**
		 *ricevutaSostitutivaCartaCircolazioneVeicoloEPService.delete(getRicevutaSostitutivaCartaCircolazioneVeicoloEP());
		 **/
		// spring test doesn't commit by default. 
		// using setComplete() all the changes made in this test case will be persisted
		//setComplete();
	}

	private RicevutaSostitutivaCartaCircolazioneVeicoloEPExt getRicevutaSostitutivaCartaCircolazioneVeicoloEP() {
		RicevutaSostitutivaCartaCircolazioneVeicoloEPExt ricevutaSostitutivaCartaCircolazioneVeicoloEPExt = RicevutaSostitutivaCartaCircolazioneVeicoloEPFactoryExt.getNewEntity();

		// put your code here in order to populate the entity RicevutaSostitutivaCartaCircolazioneVeicoloEPExt
		ricevutaSostitutivaCartaCircolazioneVeicoloEPExt.setCodUffConcessionario("RM");
		ricevutaSostitutivaCartaCircolazioneVeicoloEPExt.setCodiceConcessionario("1002");
		GregorianCalendar gc = new GregorianCalendar(2011,11,5);
		Timestamp ts = new Timestamp (gc.getTimeInMillis ());
		ricevutaSostitutivaCartaCircolazioneVeicoloEPExt.setDataAnnotazioneRicevutaSostitutiva(ts);
		ricevutaSostitutivaCartaCircolazioneVeicoloEPExt.setProgressivoRilascioRicevutaSostitutiva(10);
		return ricevutaSostitutivaCartaCircolazioneVeicoloEPExt;
	}

}
