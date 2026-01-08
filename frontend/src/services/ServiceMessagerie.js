/**
 * Service Mock pour la messagerie Alumni
 * Simule des appels API avec latence
 */

const MOCK_CURRENT_USER_ID = "me";

const MOCK_CONVERSATIONS = [
    {
        id: "conv_1",
        participants: [
            { id: "me", name: "Moi", avatar: null },
            { id: "u2", name: "Sophie Martin", avatar: "https://ui-avatars.com/api/?name=Sophie+Martin&background=random" }
        ],
        lastMessage: {
            text: "Merci pour ton aide sur le projet Java !",
            timestamp: new Date(Date.now() - 1000 * 60 * 10).toISOString(), // Il y a 10 min
            read: false,
            senderId: "u2"
        },
        unreadCount: 1,
        isArchived: false
    },
    {
        id: "conv_2",
        participants: [
            { id: "me", name: "Moi", avatar: null },
            { id: "u3", name: "Thomas Dubreuil", avatar: "https://ui-avatars.com/api/?name=Thomas+Dubreuil&background=random" }
        ],
        lastMessage: {
            text: "On se voit à l'afterwork jeudi ?",
            timestamp: new Date(Date.now() - 1000 * 60 * 60 * 2).toISOString(), // Il y a 2h
            read: true,
            senderId: "me"
        },
        unreadCount: 0,
        isArchived: false
    },
    {
        id: "conv_3",
        participants: [
            { id: "me", name: "Moi", avatar: null },
            { id: "u4", name: "Marie Curie", avatar: "https://ui-avatars.com/api/?name=Marie+Curie&background=random" }
        ],
        lastMessage: {
            text: "Félicitations pour ton nouveau poste !",
            timestamp: new Date(Date.now() - 1000 * 60 * 60 * 24 * 2).toISOString(), // Il y a 2 jours
            read: true,
            senderId: "u4"
        },
        unreadCount: 0,
        isArchived: true
    }
];

const MOCK_MESSAGES = {
    "conv_1": [
        { id: "m1", senderId: "me", text: "Salut Sophie, tu as pu regarder le bug ?", timestamp: new Date(Date.now() - 1000 * 60 * 30).toISOString() },
        { id: "m2", senderId: "u2", text: "Oui ! C'était juste un problème de configuration Maven.", timestamp: new Date(Date.now() - 1000 * 60 * 15).toISOString() },
        { id: "m3", senderId: "u2", text: "Merci pour ton aide sur le projet Java !", timestamp: new Date(Date.now() - 1000 * 60 * 10).toISOString() }
    ],
    "conv_2": [
        { id: "m4", senderId: "u3", text: "Salut ! Tu vas bien ?", timestamp: new Date(Date.now() - 1000 * 60 * 60 * 3).toISOString() },
        { id: "m5", senderId: "me", text: "Ça va super et toi ?", timestamp: new Date(Date.now() - 1000 * 60 * 60 * 2.5).toISOString() },
        { id: "m6", senderId: "me", text: "On se voit à l'afterwork jeudi ?", timestamp: new Date(Date.now() - 1000 * 60 * 60 * 2).toISOString() }
    ],
    "conv_3": [
        { id: "m7", senderId: "u4", text: "Félicitations pour ton nouveau poste !", timestamp: new Date(Date.now() - 1000 * 60 * 60 * 24 * 2).toISOString() }
    ]
};

// Simulation de latence réseau
const delay = (ms) => new Promise(resolve => setTimeout(resolve, ms));

// Simulation d'erreur aléatoire (10% de chance)
const maybeThrowError = () => {
    if (Math.random() < 0.1) {
        throw new Error("Erreur réseau simulée (Service Unavailable)");
    }
}

export const ServiceMessagerie = {
    getConversations: async () => {
        await delay(800);
        // maybeThrowError(); // Décommenter pour tester les erreurs
        return [...MOCK_CONVERSATIONS].sort((a, b) => new Date(b.lastMessage.timestamp) - new Date(a.lastMessage.timestamp));
    },

    getMessages: async (conversationId) => {
        await delay(500);
        const messages = MOCK_MESSAGES[conversationId] || [];
        return messages;
    },

    sendMessage: async (conversationId, text) => {
        await delay(300);
        const newMessage = {
            id: `m_${Date.now()}`,
            senderId: MOCK_CURRENT_USER_ID,
            text,
            timestamp: new Date().toISOString()
        };

        // Mettre à jour le mock en mémoire
        if (!MOCK_MESSAGES[conversationId]) {
            MOCK_MESSAGES[conversationId] = [];
        }
        MOCK_MESSAGES[conversationId].push(newMessage);

        // Mettre à jour la dernière conversation
        const convIndex = MOCK_CONVERSATIONS.findIndex(c => c.id === conversationId);
        if (convIndex !== -1) {
            MOCK_CONVERSATIONS[convIndex].lastMessage = {
                text,
                timestamp: newMessage.timestamp,
                read: true,
                senderId: MOCK_CURRENT_USER_ID
            };
            // Remonter la conversation en haut (simple hack pour le mock)
            const conv = MOCK_CONVERSATIONS.splice(convIndex, 1)[0];
            MOCK_CONVERSATIONS.unshift(conv);
        }

        return newMessage;
    },

    markAsRead: async (conversationId) => {
        await delay(200);
        const conv = MOCK_CONVERSATIONS.find(c => c.id === conversationId);
        if (conv) {
            conv.unreadCount = 0;
            conv.lastMessage.read = true;
        }
    },

    getCurrentUserId: () => MOCK_CURRENT_USER_ID
};
