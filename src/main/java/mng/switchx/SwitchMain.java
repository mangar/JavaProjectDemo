//package mng.main;

void main() {
    IO.println("⚠️ Switch.Main ️️ ⚠️\n------------------");

    PaymentStatus.PENDING.handle();
    PaymentStatus.APPROVED.handle();
    PaymentStatus.CANCELLED.handle();

}


public enum PaymentStatus {
    PENDING {
        public void handle() {
            PaymentServiceRetry.create().handle();
        }
    },

    APPROVED {
        public void handle() {
            PaymentServicePayment.create().handle();
        }
    },

    CANCELLED {
        public void handle() {
            PaymentServiceCancel.create().handle();
        }
    };

    public abstract void handle();

}


public abstract static class PaymentService {
    public abstract void handle();

    public static PaymentService create(PaymentStatus status) {
        if (status == PaymentStatus.PENDING) {
            return PaymentServiceRetry.create();
        } else if (status == PaymentStatus.APPROVED) {
            return PaymentServiceRetry.create();
        } else if (status == PaymentStatus.CANCELLED) {
            return PaymentServiceRetry.create();
        } else {
            return PaymentServiceNone.create();
        }
    }

}

public static final class PaymentServiceRetry extends PaymentService {
    private PaymentServiceRetry() {
    }

    public static PaymentServiceRetry create() {
        return new PaymentServiceRetry();
    }

    public void handle() {
        IO.println("♻️ Retry()");
    }
}

public static final class PaymentServicePayment extends PaymentService {
    private PaymentServicePayment() {
    }

    public static PaymentServicePayment create() {
        return new PaymentServicePayment();
    }

    public void handle() {
        IO.println("💳 Proceed Payment()");
    }
}

public static final class PaymentServiceCancel extends PaymentService {
    private PaymentServiceCancel() {
    }

    public static PaymentServiceCancel create() {
        return new PaymentServiceCancel();
    }

    public void handle() {
        IO.print("❌ Cancel Transaction()");
    }
}

public static final class PaymentServiceNone extends PaymentService {
    private PaymentServiceNone() {
    }

    public static PaymentServiceNone create() {
        return new PaymentServiceNone();
    }

    public void handle() {
        IO.print(">> NONE");
    }
}