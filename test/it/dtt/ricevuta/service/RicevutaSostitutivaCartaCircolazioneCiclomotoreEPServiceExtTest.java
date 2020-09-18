package it.dtt.ricevuta.service;

import it.dtt.ricevuta.entity.ext.RicevutaSostitutivaCartaCircolazioneCiclomotoreEPExt;
import it.dtt.ricevuta.service.ext.RicevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.test.AbstractTransactionalSpringContextTests;

public class RicevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExtTest extends AbstractTransactionalSpringContextTests
{
	/**
	 * Default logger
	 */
	protected static Log logger = LogFactory.getLog(RicevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExtTest.class);

	private RicevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt ricevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt;

	protected String[] getConfigLocations()
	{
		return new String[] {
				"classpath*:it/dtt/ricevuta/propertyConfigurer.xml",
				"classpath*:it/dtt/ricevuta/applicationContext.xml",
				"classpath*:it/dtt/ricevuta/applicationContext-Model.xml",
				"classpath*:it/dtt/ricevuta/applicationContext-DAO.xml",
				"classpath*:it/dtt/ricevuta/applicationContext-POJO.xml" };
	}

	public RicevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt getRicevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt()
	{
		return ricevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt;
	}

	public void setRicevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt(RicevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt ricevutaSostitutivaCartaCircolazioneCiclomotoreEPService)
	{
		this.ricevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt = ricevutaSostitutivaCartaCircolazioneCiclomotoreEPService;
	}

	public void testDetail()
	{
		ricevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt.detail(getRicevutaSostitutivaCartaCircolazioneCiclomotoreEPExt());

	}

	public void testInsert()
	{
		ricevutaSostitutivaCartaCircolazioneCiclomotoreEPServiceExt.insert(getRicevutaSostitutivaCartaCircolazioneCiclomotoreEPExt());

		// spring test doesn't commit by default.
		// using setComplete() all the changes made in this test case will be
		// persisted
		// setComplete();

		// endTransaction() closes the db transaction.
		// useful for testing puroposes on beans values after the db connection
		// closure
		// endTransaction();
	}

	private RicevutaSostitutivaCartaCircolazioneCiclomotoreEPExt getRicevutaSostitutivaCartaCircolazioneCiclomotoreEPExt()
	{
		RicevutaSostitutivaCartaCircolazioneCiclomotoreEPExt ricevutaSostitutivaCartaCircolazioneCiclomotoreEP = new RicevutaSostitutivaCartaCircolazioneCiclomotoreEPExt();

		// put your code here in order to populate the entity
		// RicevutaSostitutivaCartaCircolazioneCiclomotoreEPExt

		return ricevutaSostitutivaCartaCircolazioneCiclomotoreEP;
	}

}
