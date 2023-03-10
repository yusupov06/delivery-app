package uz.md.shopapp.exceptions;

import lombok.Builder;

@Builder
public class AccessKeyInvalidException extends RuntimeException {

    private String messageUz;
    private String messageRu;

    public AccessKeyInvalidException(String messageUz, String messageRu) {
        super(messageUz);
        this.messageUz = messageUz;
        this.messageRu = messageRu;
    }
}
