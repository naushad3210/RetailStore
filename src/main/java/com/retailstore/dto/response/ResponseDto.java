package com.retailstore.dto.response;

import java.io.Serializable;

/**
 * @author mohammadnaushad
 *
 * @param <T>
 */
public class ResponseDto<T> implements Serializable {

	private static final long serialVersionUID = 2590085546362795552L;
	
	T body;

	public T getBody() {
		return body;
	}

	public void setBody(T body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "ResponseDto [body=" + body + "]";
	}

	@SuppressWarnings("rawtypes")
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ResponseDto other = (ResponseDto) obj;
		if (body == null) {
			if (other.body != null)
				return false;
		} else if (!body.equals(other.body))
			return false;
		return true;
	}
	
}
