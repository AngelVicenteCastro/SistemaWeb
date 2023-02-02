package com.mx.mex.Repository;

import java.io.Serializable;

public interface DAO<T, PK> extends Serializable{ // T ESLA ENTIDAD Y PK ES LA LLAVE PRIMARIA
	PK create(final T newInstance);

	   T read(final PK id);

	   void update(final T transientObject);

	   void delete(final PK persistentObjectId);

	   void updateWithNoFlush(final T transientObject);

	   void flush();

	   void saveOrUpdate(final T transientObject);
}
