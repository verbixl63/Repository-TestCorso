package it.dtt.ricevuta.service;

import it.dtt.ricevuta.entity.ext.RicevutaSostitutivaDocumentoCircolazioneEmessoEPExt;
import it.dtt.ricevuta.service.ext.RicevutaSostitutivaDocumentoCircolazioneEmessoEPServiceExt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractTransactionalSpringContextTests;

public class RicevutaSostitutivaDocumentoCircolazioneEmessoEPServiceExtTest extends
		AbstractTransactionalSpringContextTests {
	/**
	 * Default logger
	 */
	protected static Log logger = LogFactory
			.getLog(RicevutaSostitutivaDocumentoCircolazioneEmessoEPServiceExtTest.class);

	private RicevutaSostitutivaDocumentoCircolazioneEmessoEPServiceExt ricevutaSostitutivaDocumentoCircolazioneEmessoEPService;

	protected String[] getConfigLocations() {
		return new String[] {
				"classpath*:it/dtt/ricevuta/propertyConfigurer.xml",
				"classpath*:it/dtt/ricevuta/applicationContext.xml",
				"classpath*:it/dtt/ricevuta/applicationContext-Model.xml",
				"classpath*:it/dtt/ricevuta/applicationContext-DAO.xml",
				"classpath*:it/dtt/ricevuta/applicationContext-POJO.xml" };
	}

	public RicevutaSostitutivaDocumentoCircolazioneEmessoEPServiceExt getRicevutaSostitutivaDocumentoCircolazioneEmessoEPService() {
		return ricevutaSostitutivaDocumentoCircolazioneEmessoEPService;
	}

	public void setRicevutaSostitutivaDocumentoCircolazioneEmessoEPService(
			RicevutaSostitutivaDocumentoCircolazioneEmessoEPServiceExt ricevutaSostitutivaDocumentoCircolazioneEmessoEPService) {
		this.ricevutaSostitutivaDocumentoCircolazioneEmessoEPService = ricevutaSostitutivaDocumentoCircolazioneEmessoEPService;
	}

	public void testDetail() {
		ricevutaSostitutivaDocumentoCircolazioneEmessoEPService
				.detail(getRicevutaSostitutivaDocumentoCircolazioneEmessoEP());

	}

	public void testInsert() {
		ricevutaSostitutivaDocumentoCircolazioneEmessoEPService
				.insert(getRicevutaSostitutivaDocumentoCircolazioneEmessoEP());

		// spring test doesn't commit by default. 
		// using setComplete() all the changes made in this test case will be persisted
		//setComplete();

		// endTransaction() closes the db transaction.
		// useful for testing puroposes on beans values after the db connection closure
		//endTransaction();
	}

	public void testUpdate() {
		/**
		 *ricevutaSostitutivaDocumentoCircolazioneEmessoEPService.update(getRicevutaSostitutivaDocumentoCircolazioneEmessoEP());
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
		 *ricevutaSostitutivaDocumentoCircolazioneEmessoEPService.delete(getRicevutaSostitutivaDocumentoCircolazioneEmessoEP());
		 **/
		// spring test doesn't commit by default. 
		// using setComplete() all the changes made in this test case will be persisted
		//setComplete();
	}

	private RicevutaSostitutivaDocumentoCircolazioneEmessoEPExt getRicevutaSostitutivaDocumentoCircolazioneEmessoEP() {
		RicevutaSostitutivaDocumentoCircolazioneEmessoEPExt ricevutaSostitutivaDocumentoCircolazioneEmessoEP = new RicevutaSostitutivaDocumentoCircolazioneEmessoEPExt();

		// put your code here in order to populate the entity RicevutaSostitutivaDocumentoCircolazioneEmessoEPExt

		return ricevutaSostitutivaDocumentoCircolazioneEmessoEP;
	}

}
