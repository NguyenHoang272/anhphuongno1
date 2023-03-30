import { Product } from "./product";

export interface Piano {
    id?: number;
    numberOfKeys?: string;
    keySensitivity?: string;
    pianoSound?: string;
    maxPolyphony?: string;
    numberOfSounds?: string;
    pianoEffect?: string;
    pianoFunction?: string;
    pianoMetronome?: string;
    pianoTranspose?: string;
    pianoTuning?: string;
    connectMethod?: string;
    pianoAmp?: string;
    pianoSpeaker?: string;
    energyConsumption?: string;
    pianoAccessories?: string;
    pianoSize?: string;
    pianoWeight?: string;
    deleteStatus?: string;
    product?: Product;
}
