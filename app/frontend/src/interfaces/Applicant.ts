import { Status } from "../enums/Status";

export interface Applicant {
  id: string;
  name: string;
  status: Status;
}
